package Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.logging.Logger;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;
import org.junit.rules.TestWatcher;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class JiraTicketonFailure extends TestWatcher {

//    private String jiraBaseUrl = "https://demoserenity.atlassian.net";
//    private String jiraUsername = "neha.kale@verinite.com";
//    private String jiraPassword = "ATATT3xFfGF06v9sD6_caxgxgpqBX70ok4Fk2S4GYwWyLmHPQ22JTvOLgMxDZk45ch-9SkoAnA3dQ_GgGo2OrhumMK_RooOugwSvqrQ-xTA8UcXrnG6IApxYLiLynXoqa0siIEdTAvfDXa2CvnWcM_AhkaHgRYol2peVr9BbNoYsuP4-7gUC7DI=F4FA1E0F";
//    private String jiraProjectKey = "SCRUM";
	private String jiraBaseUrl = "https://verinite-team-itn5zr3m.atlassian.net";
    private String jiraUsername = "sumeet.bandgar@verinite.com";
    private String jiraPassword = "ATATT3xFfGF0jlvIwAMVe9hKTwIxcwKd3pp2_8SMzrBU6nB_1rdWavAzAF3MuqohLYd2sFXqYcyuD2_I4IF54FjTaO8s9MF8rWtot35yQwltvrbgZSl6aqkuCQNpspyHATjP4RCCqS0UWIllQQr4Yebns4UUOzPkY_fUqzQFb36_9dqH6GOXWY4=9CE11053";
    private String jiraProjectKey = "KAN";
    private static final Logger logger = Logger.getLogger(JiraTicketonFailure.class.getName());

   /* @Override
    protected void failed(Throwable e, Description description)
    {
        //createJiraIssue(description.getMethodName(), e.getMessage());
        try {
        String s=    createTicket(jiraProjectKey, description.getMethodName(),  e.getMessage());
            System.out.println("Id: "+s);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }*/
    public String createJiraIssue(String testName, String errorMessage) {
        String issueSummary = "Automated Test Failure: " + testName;
        String issueDescription = "Test Case: " + testName + " Error Message: " + errorMessage;

        String jsonBody = "{" + "\"fields\": {" + "\"project\": {" + "\"key\": \""
                + jiraProjectKey + "\"," + "\"description\": \"" + issueDescription + "\"},"
                + "        \"summary\": \"" + issueSummary + "\"," + "\"issuetype\": {\"name\": \"Bug\"}}}";

        Response response = RestAssured.given().auth().preemptive().basic(jiraUsername, jiraPassword)
                .header("Content-Type", "application/json").body(jsonBody).post(jiraBaseUrl + "/rest/api/2/issue/");
        String responseAsString = response.getBody().asString();
        JSONObject jsonResponse = new JSONObject(responseAsString);
        String issueKey = jsonResponse.getString("key");
        logger.info("Jira issue has been created " + issueKey);
        return issueKey;
    }

    public String createTicket(String testName,String errorMessage, String runPlanId) throws IOException {
        String apiUrl = jiraBaseUrl + "/rest/api/2/issue/";
        String summary = "[Automated] Run Plan [" + runPlanId + "] :: Test Name :" + testName;
        String description = "Test Case: " + testName + " Error Message: " + errorMessage;
        JSONObject json = new JSONObject();
        JSONObject fields = new JSONObject();
        fields.put("summary", summary);
        fields.put("description", description);
        fields.put("issuetype", new JSONObject().put("name", "Bug"));
        fields.put("project", new JSONObject().put("key", jiraProjectKey));
        json.put("fields", fields);
        StringBuilder responseStringBuilder = new StringBuilder();
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost request = new HttpPost(apiUrl);
            request.setHeader("Content-Type", "application/json");
            String auth = jiraUsername + ":" + jiraPassword;
            byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.UTF_8));
            String authHeader = "Basic " + new String(encodedAuth, StandardCharsets.UTF_8);
            request.setHeader("Authorization", authHeader);

            StringEntity entity = new StringEntity(json.toString());
            request.setEntity(entity);

            try (CloseableHttpResponse response = httpClient.execute(request)) {
                if (response.getStatusLine().getStatusCode() != 201) {
                    throw new RuntimeException("Failed to create JIRA ticket: " + response.getStatusLine());
                }
                HttpEntity entity1 = response.getEntity();
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(entity1.getContent(), StandardCharsets.UTF_8))) {

                    String line;
                    while ((line = reader.readLine()) != null) {
                        responseStringBuilder.append(line);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        JSONObject responseJson = new JSONObject(responseStringBuilder.toString());
        logger.info("Jira issue has been created " + responseJson.getString("key"));
        return responseJson.getString("key");
    }

}
