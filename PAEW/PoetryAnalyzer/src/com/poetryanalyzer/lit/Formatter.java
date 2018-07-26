package com.poetryanalyzer.lit;

public static class Formatter {
	public static final String htmlStart ='<!DOCTYPE html><title>Poem</title><link rel="stylesheet" type="text/css" href="style.css"><body lang ="en">';
	public static final String htmlEnd ="</body>";
	public static final String lineStart ='<span class="';
	public static final String lineMid1 = '" data = "';
	public static final String lineMid2 = '">';
	public static final String lineEnd ="</span>";
	public static String GenerateHTML(Poem poem) {
		String html = htmlStart;
		for(Line line:poem.lines) {
			var devices = line.
			html += lineStart+line.
		}
		html += htmlEnd;
		return html;
	}
}
