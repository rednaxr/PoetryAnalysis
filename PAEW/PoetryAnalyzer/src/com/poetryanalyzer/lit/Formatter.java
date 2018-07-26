package com.poetryanalyzer.lit;

<<<<<<< HEAD
public class Formatter {
	
	public static final String htmlStart ='<!DOCTYPE html><title>Poem</title><link rel="stylesheet" type="text/css" href="style.css"><body lang ="en">';
=======
public static class Formatter {
	//s=start of a tag/section, e=end of a tag/section
	public static final String htmlStart ="<!DOCTYPE html><title>Poem</title><link rel=\"stylesheet\" type=\"text\\css\" href=\"style.css\"><body lang =\"en\">";
>>>>>>> 056de7f1e99c355c357052ed71a59a76b5e1b53b
	public static final String htmlEnd ="</body>";
	public static final String lineStart = "<span class=\"";
	public static final String dataS = " data-alliteration =\"";
	public static final String dataE = "\">";
	public static final String lineEnd ="</span>";
	public static String GenerateHTML(Poem poem) {
		String html = htmlStart;
<<<<<<< HEAD
		for(Line line : poem.lines) {
=======
		for(Line line:poem.getLines()) {
>>>>>>> 056de7f1e99c355c357052ed71a59a76b5e1b53b
			var devices = line.
			html += lineStart+line.getText()+dataS+line.getDevices().alliteration.hasValue()+dataE+lineEnd;
		}
		html += htmlEnd;
		return html;
	}
}
