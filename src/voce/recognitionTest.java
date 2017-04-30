package voce;

import java.io.IOException;

public class recognitionTest
{
	public static void main(String[] argv)
	{
		voce.SpeechInterface.init("/lib", false, true, "/grammar", "digits");
 //Configuration configuration = new Configuration();

       // configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
       // configuration.setDictionaryPath("edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
        //configuration.setLanguageModelPath("edu/cmu/sphinx/models/en-us/en-us.lm.bin");
		System.out.println("This is a speech recognition test. " 
			+ "Speak digits from 0-9 into the microphone. " 
			+ "Speak 'quit' to quit.");

		boolean quit = false;
		while (!quit)
		{
			// Normally, applications would do application-specific things 
			// here.  For this sample, we'll just sleep for a little bit.
			try
			{
				Thread.sleep(200);
			}
			catch (InterruptedException e)
			{
			}

			while (voce.SpeechInterface.getRecognizerQueueSize() > 0)
			{
				String s = voce.SpeechInterface.popRecognizedString();

				// Check if the string contains 'quit'.
				if (-1 != s.indexOf("quit"))
				{
					quit = true;
				}

				System.out.println("You said: " + s);
                                
                                
                                
           switch (s) {
               case "facebook.com":
               case "fb.me":
                case "open facebook":
                case "let me post":
                case "fb":
                case "missing friends":
                case "show my friends posts":
                case "just open the facebook":
                case "facebook":
                case "open the facebook":
                case "open my facebook":
                   /* if(a.equals("facebook"))
                    {*/
                {
                    Runtime rs = Runtime.getRuntime();
                    try {
                        rs.exec(new String[]{"cmd", "/c","start chrome http://facebook.com"});
                        //voice.speak("just opening the facebook for you sir");
                    }
                    catch (IOException e) {
                        System.out.println(e);
                    }
                }  break;
                case "let me draw":
                case "open paint":
                case "open the paint":
                case "paint":
                case "let me paint":
                {
                    Runtime rs = Runtime.getRuntime();
                    try {
                        rs.exec("mspaint");
                      //  voice.speak("just opening the paint for you sir");
                    }
                    catch (IOException e) {
                        System.out.println(e);
                    }
                }  break;
                default:
                    int i,j,n,count=0,mail=0;
                    n=s.length();
                    System.out.println(n);
                    for(i=0;i<n;i++)
                    {
                        for(j=i+1;j<n+1;j++)
                        {
                            String a=s.substring(i,j);
                           // System.out.println(s+"\n");
                            if(a.equals("notepad"))
                            {
                                {
                                    Runtime rs = Runtime.getRuntime();
                                    try {
                                        count++;
                                        rs.exec("notepad");
                                        // rs.exec("mspaint");
                                      //  voice.speak("just opening the notepad for you sir");

                                    }
                                    catch (IOException e) {
                                        System.out.println(e);
                                    }
                                }
                            }
                            else if(a.equals("explorer") || a.equals("internet") || a.equals("google") || a.equals("search"))
                            {
                                {
                                    Runtime rs = Runtime.getRuntime();
                                    try {
                                        count++;
                                        rs.exec(new String[]{"cmd", "/c","start chrome http://google.com"});
                                        // rs.exec("mspaint");
                                        //voice.speak("opening the browser for you sir");

                                    }
                                    catch (IOException e) {
                                        System.out.println(e);
                                    }
                                }
                            }
                            
                            else    if(a.equals("gmail"))
                                {
                                
                                    Runtime rs = Runtime.getRuntime();
                                    try {
                                        mail++;
                                        count++;
                                        rs.exec(new String[]{"cmd", "/c","start chrome http://gmail.com"});
                                        // rs.exec("mspaint");
                                       //voice.speak("opening the gmail for you sir");

                                    }
                                    catch (IOException e) {
                                        System.out.println(e);
                                    }
                                }
                                else
                                     if(a.equals("outlook"))
                                {
                                
                                    Runtime rs = Runtime.getRuntime();
                                    try {
                                        mail++;
                                        count++;
                                        rs.exec(new String[]{"cmd", "/c","start chrome http://outlook.com"});
                                        // rs.exec("mspaint");
                                     //  voice.speak("opening the outlook for you sir");

                                    }
                                    catch (IOException e) {
                                        System.out.println(e);
                                    }
                                }
                                     else if (a.equals("email") && mail==0) {
                                         count++;
                                       //  voice.speak("Cannot understand you");
                                         //voice.speak("Sir please tell which email services do you want to open or access");
                                        // voice.speak("gmail or outlook");
                                         break;
                                     }
           

                            
                        }
                    }
           }
                                
                                
                                
				//voce.SpeechInterface.synthesize(s);
			}
		}

		voce.SpeechInterface.destroy();
		System.exit(0);
	}
}

