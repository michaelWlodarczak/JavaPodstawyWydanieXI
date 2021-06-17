package rozdzial7.logging;

import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

public class WindowHandler extends StreamHandler {
    private JFrame frame;

    public WindowHandler() {
        frame = new JFrame();
        var output = new JTextArea();
        output.setEditable(false);
        frame.setSize(200,200);
        frame.add(new JScrollPane(output));
        frame.setFocusableWindowState(false);
        frame.setVisible(true);
        setOutputStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {  // ??
            }

            @Override
            public void write(byte[] b, int off,int len) throws IOException {
                output.append(new String(b,off,len));
            }
        });
    }
    public void publish(LogRecord record){
        if (!frame.isVisible()) return;
        super.publish(record);
        flush();
    }
}
