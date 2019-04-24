package chat.src;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Main extends Activity {

        private final String VM_TO_HOST_IP   =   "10.0.2.2";
        private final int DEFAULT_PORT    =   7777;
        protected String server_address;
        protected String hostName;
        protected AsyncTask<Void, String, Void> watch_server;
        protected Socket server_socket;
        protected EditText chatRoom;
        protected EditText chatInput;
        protected Button exitButton;
        protected Button sendButton;

        /** Called when the activity is first created. */
        @Override
        public void onCreate(Bundle savedInstanceState) {

                super.onCreate(savedInstanceState);
                super.
                setContentView(R.layout.main);

                // used as a place holder, unnecessary unless
                // the user input changes the server address on start
                server_address = VM_TO_HOST_IP;
                /*
                 * Get locations of all UI elements
                 */
                chatRoom    = (EditText)findViewById(R.id.textRoom);
                chatInput   = (EditText)findViewById(R.id.chatInput);
                exitButton  = (Button)findViewById(R.id.exitButton);
                sendButton  = (Button)findViewById(R.id.chatButton);

                /*
                 * Create Socket
                 */
                try {
                        chatRoom.append("Connecting to: " + server_address + "\n");

                        server_socket = new Socket(server_address, DEFAULT_PORT);
                        hostName      = server_socket.getInetAddress().getHostName();

                        chatRoom.append("Connected\n");
                } catch (UnknownHostException e) {
                        Log.e("Socket Creation", "Unknown Host: " + e.toString());
                        System.exit(0);
                } catch (IOException e) {
                        Log.e("Socket Creation", "IO Exception: " + e.toString());
                        System.exit(0);
                }

                /*
                 * Check Server Input Task
                 */
                watch_server = new serverSync();
                watch_server.execute();

        }

        public void sendButtonClicked(View view) {
                Log.d("Send Clicked", "Send Button Clicked");
                try {
                        String text = chatInput.getText().toString();
                        OutputStream output = server_socket.getOutputStream();
                        output.write(new String(text).getBytes());
                        output.flush();
                        chatInput.setText("");
                }
                catch (IOException ex) {
                        Log.e("Send Error", ex.toString());
                }

        }

        public void exitButtonClicked(View view) {
                Log.d("Exit Clicked", "Exit Button Clicked");
                try {
                        watch_server.cancel(true);
                        server_socket.close();
                        System.exit(0);
                } catch (IOException e) {
                        Log.e("Close Socket Error", e.toString());
                }
        }

        protected class serverSync extends AsyncTask<Void, String, Void> {
                @Override
                protected Void doInBackground(Void... param) {
                        while (true) {
                                try {
                                        InputStream input     = server_socket.getInputStream();
                                        int available         = input.available();

                                        if (available > 0) {
                                                byte[] bytes = new byte[available];
                                                input.read(bytes);
                                                publishProgress(new String(bytes) + "\n");
                                        }

                                        Thread.sleep(10);
                                }
                                catch (IOException ex) {
                                        Log.e("serverSync Error", "Listen failed " + ex);
                                }
                                catch (InterruptedException ex) {
                                        Log.e("serverSync Error", "Sleep interrupted " + ex);
                                }
                        }
                }
                @Override
                protected void onProgressUpdate(String... chat) {
                        chatRoom.append(chat[0]);
                }

        }
}
