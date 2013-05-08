/**
 * Javascript for all purposes
 */

/**
 * use this function to delete records.
 */
function erase() {
	var erase = window.confirm("You're right about the exclusion of this record?");
	if (erase == true) {
		return true;
	}

	if (erase == false) {
		alert("No record has been deleted!");
		abort;
		return false;
	}
}