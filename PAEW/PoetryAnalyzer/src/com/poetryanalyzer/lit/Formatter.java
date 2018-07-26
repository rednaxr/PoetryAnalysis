package com.poetryanalyzer.lit;

public class Formatter {
	
	public static final String htmlStart ='<!DOCTYPE html><title>Poem</title><link rel="stylesheet" type="text/css" href="style.css"><body lang ="en">';

public static class Formatter {
	//s=start of a tag/section, e=end of a tag/section
	public static final String htmlStart ="<!DOCTYPE html><title>Poem</title><link rel=\"stylesheet\" type=\"text\\css\" href=\"style.css\"><body lang =\"en\">";

	public static final String htmlEnd ="</body>";
	public static final String lineStart = "<span class=\"";
	public static final String dataS = " data-alliteration =\"";
	public static final String dataE = "\">";
	public static final String lineEnd ="</span>";
	public static String GenerateHTML(Poem poem) {
		String html = htmlStart;

		for(Line line : poem.lines) {

		for(Line line:poem.getLines()) {

			var devices = line.
			html += lineStart+line.getText()+dataS+line.getDevices().alliteration.hasValue()+dataE+lineEnd;
		}
		html += htmlEnd;
		return html;
	}
}
