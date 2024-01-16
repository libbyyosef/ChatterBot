import java.util.*;

/**
 * Base file for the ChatterBot exercise.
 * The bot's replyTo method receives a statement.
 * If it starts with the constant REQUEST_PREFIX, the bot returns
 * whatever is after this prefix. Otherwise, it returns one of
 * a few possible replies as supplied to it via its constructor.
 * In this case, it may also include the statement after
 * the selected reply (coin toss).
 * @author Dan Nirel
 */
class ChatterBot {
	static final String REQUEST_PREFIX = "say ";
	static final String REQUESTED_PHRASE_PLACEHOLDER = "<phrase>";
	static final String ILLEGAL_REQUEST_PLACEHOLDER = "<request>";
	Random rand = new Random();
	String[] repliesToLegalRequest;
	String[] repliesToIllegalRequest;
	private String name;
	//chatterbot constructor
	ChatterBot(String name,String[] repliesToLegalRequest,String [] repliesToIllegalRequest) {
		this.name=name;
		this.repliesToLegalRequest=repliesToLegalRequest;
		this.repliesToIllegalRequest = new String[repliesToIllegalRequest.length];
		//copying each string in the given strings array to the repliesToLegalRequest strings array
		for(int i = 0 ; i < repliesToIllegalRequest.length ; i = i+1) {
			this.repliesToIllegalRequest[i] = repliesToIllegalRequest[i];
		}
	}

	String replyTo(String statement) {
		if(statement.startsWith(REQUEST_PREFIX)) {
			//we don’t repeat the request prefix, so delete it from the reply
			//this method returns a reply string to a given statement according to its prefix

			return this.replacePlaceholderInARandomPattern(REQUESTED_PHRASE_PLACEHOLDER,
					statement.replaceFirst(REQUEST_PREFIX, ""),this.repliesToLegalRequest);
		}
		return this.replacePlaceholderInARandomPattern(ILLEGAL_REQUEST_PLACEHOLDER, statement,
				this.repliesToIllegalRequest);
	}

	String replacePlaceholderInARandomPattern(String placeHolder,String statement, String [] responses){
		//this method choose a reply statement randomly from the responses array, replace the placeholder
		// in the statement and returns the reply method
		int randomIndex = rand.nextInt(responses.length);
		String reply = responses[randomIndex];
		reply=reply.replaceAll(placeHolder,statement);
		return reply;
	}

	public String getName() {
		//return the name of the chatterbot
		return name;
	}
}
