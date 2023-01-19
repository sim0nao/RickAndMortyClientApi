package response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CharacterResponse {

	private int id;
	
	private String name;
	
	private String status;
	
	private String species;
	
	private String image;
	
	private List<String> episosode;
}
