function generateTimestamp(form) {
	form[form.id + ":timestamp"].value = new Date();
}

function showProgress(data) {
	console.log("SHOW PROGRESS======================================================================================");
	console.log("description: " + data.description);
	console.log("status: " + data.status);
	console.log("type: " + data.type);
	console.log("source.id: " + data.source.id);
	console.log("responseCode: " + data.responseCode);
	console.log("responseText: " + data.responseText);
	console.log("responseXML: " + data.responseXML);
	console.log("source: " + data.source);
	console.log("data: " + data);
}

function showError(data) {
	console.log("SHOW ERROR======================================================================================");
	console.log("description: " + data.description);
	console.log("errorName: " + data.errorName);
	console.log("errorMessage: " + data.errorMessage);
	console.log("status: " + data.status);
	console.log("type: " + data.type);
	console.log("source.id: " + data.source.id);
	console.log("responseCode: " + data.responseCode);
	console.log("responseText: " + data.responseText);
	console.log("responseXML: " + data.responseXML);
	console.log("source: " + data.source);
	console.log("data: " + data);
}