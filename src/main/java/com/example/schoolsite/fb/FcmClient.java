package com.example.schoolsite.fb;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class FcmClient {
  /*  public FcmClient(FcmSettings settings) {
        Path p = Paths.get(settings.getServiceAccountFile());
        try (InputStream serviceAccount = Files.newInputStream(p)) {
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            FirebaseApp.initializeApp(options);
        } catch (IOException e) {
            Logger.getLogger(FcmClient.class.getName())
                    .log(Level.SEVERE, null, e);
        }
    }*/

    /*производит отправку уведомлений пользователям подписанным на заданную тему*/
    public String sendByTopic(PushNotifyConf conf, String topic)
            throws InterruptedException, ExecutionException {

        Message message = Message.builder().setTopic(topic)
                .setWebpushConfig(WebpushConfig.builder()
                        .putHeader("ttl", conf.getTtlInSeconds())
                        .setNotification(createBuilder(conf).build())
                        .build())
                .build();

        String response = FirebaseMessaging.getInstance()
                .sendAsync(message)
                .get();
        return response;
    }

    /*реализует отправку персонального уведомления пользователю (clientToken)*/
    public String sendPersonal(PushNotifyConf conf, String clientToken)
            throws ExecutionException, InterruptedException {
        Message message = Message.builder().setToken(clientToken)
                .setWebpushConfig(WebpushConfig.builder()
                        .putHeader("ttl", conf.getTtlInSeconds())
                        .setNotification(createBuilder(conf).build())
                        .build())
                .build();

        String response = FirebaseMessaging.getInstance()
                .sendAsync(message)
                .get();
        return response;
    }

    /*подписывет на тему (topic) пользователей (clientTokens)*/
    public void subscribeUsers(String topic, List<String> clientTokens)
            throws FirebaseMessagingException {
        for (String token : clientTokens) {
            TopicManagementResponse response = FirebaseMessaging.getInstance()
                    .subscribeToTopic(Collections.singletonList(token), topic);
        }
    }

    /*создает сообщение*/
    private WebpushNotification.Builder createBuilder(PushNotifyConf conf){
        WebpushNotification.Builder builder = WebpushNotification.builder();
        builder.addAction(new WebpushNotification
                        .Action(conf.getClick_action(), "Открыть"))
                .setImage(conf.getIcon())
                .setTitle(conf.getTitle())
                .setBody(conf.getBody());
        return builder;
    }
}
