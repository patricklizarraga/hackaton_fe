package com.jretuerto.bootcamp.trabajofinal.data.repository;

import com.ibm.watson.assistant.v2.Assistant;
import com.ibm.watson.assistant.v2.model.CreateSessionOptions;
import com.ibm.watson.assistant.v2.model.DeleteSessionOptions;
import com.ibm.watson.assistant.v2.model.RuntimeResponseGeneric;
import com.ibm.watson.assistant.v2.model.MessageInput;
import com.ibm.watson.assistant.v2.model.MessageOptions;
import com.ibm.watson.assistant.v2.model.MessageResponse;
import com.ibm.watson.assistant.v2.model.RuntimeIntent;
import com.ibm.watson.assistant.v2.model.SessionResponse;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;

import java.util.List;

public class WatsonRepository {

    public static String CallApiWatson(String text) {

        // Configurar servicio de asistente.
        Authenticator authenticator = new IamAuthenticator("bmfDfPVw1ybIwdiMhONhjjImszfHkbuaeaP-ITBB6qjW"); // sustituir por clave de API
        Assistant service = new Assistant("2020-09-24", authenticator);
        String assistantId = "4244e47c-f5e2-4d59-92b7-d3c941325715"; // sustituir por el ID de asistente

        // Crear sesión.
        CreateSessionOptions createSessionOptions = new CreateSessionOptions.Builder(assistantId).build();
        SessionResponse session = service.createSession(createSessionOptions).execute().getResult();
        String sessionId = session.getSessionId();

        // Inicializar con un mensaje vacío para empezar la conversación.
        MessageInput input = new MessageInput.Builder()
                .messageType("text")
                .text("")
                .build();


            // Enviar mensaje al asistente.
            MessageOptions messageOptions = new MessageOptions.Builder(assistantId, sessionId)
                    .input(input)
                    .build();
            MessageResponse response = service.message(messageOptions).execute().getResult();

            // Si se detecta una intención, imprimirla en la consola.
            List<RuntimeIntent> responseIntents = response.getOutput().getIntents();
            if (responseIntents.size() > 0) {
                System.out.println("Detected intent: #" + responseIntents.get(0).intent());
            }

        // Nuevo mensaje
        input = new MessageInput.Builder()
                .messageType("text")
                .text(text)
                .build();

        // Enviar mensaje al asistente.
        messageOptions = new MessageOptions.Builder(assistantId, sessionId)
                .input(input)
                .build();

        response = service.message(messageOptions).execute().getResult();

            // Imprimir la salida del diálogo, si la hay. Se supone que solo hay una respuesta de texto.
            List<RuntimeResponseGeneric> responseGeneric = response.getOutput().getGeneric();
            if (responseGeneric.size() > 0) {
                if (responseGeneric.get(0).responseType().equals("text")) {
                    System.out.println(responseGeneric.get(0).text());
                }
            }

            String retorno = responseGeneric.get(0).text();

        // Hemos terminado, así que suprimimos la sesión.
        DeleteSessionOptions deleteSessionOptions = new DeleteSessionOptions.Builder(assistantId, sessionId).build();
        service.deleteSession(deleteSessionOptions).execute();

        return retorno;
    }
}
