package teamui;

import java.io.*;

import org.apache.batik.transcoder.*;
import org.apache.batik.transcoder.image.*;

public class createPNG {
	public void go() throws IOException, TranscoderException{
		File f = new File("WAS.svg");
		File destFile = new File("was.png");
		
		InputStream in = new FileInputStream(f);
		OutputStream out = new FileOutputStream(destFile);
		out = new BufferedOutputStream(out);
	
		convert2png(in,out);
	}

	public void convert2png(InputStream in, OutputStream out) throws IOException, TranscoderException {
		Transcoder transcoder = new PNGTranscoder();
		try {
			TranscoderInput input = new TranscoderInput(in);
			try {
				TranscoderOutput output = new TranscoderOutput(out);
				transcoder.transcode(input, output);
			} finally {
				out.close();
			}
		} finally {
			in.close();
		}
	}
	
	
}