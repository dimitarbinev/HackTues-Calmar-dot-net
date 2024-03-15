document.addEventListener('DOMContentLoaded', function() {
    const form = document.querySelector('.games-list');

    form.addEventListener('submit', function(event) {
        // Prevent the form from submitting the traditional way
        event.preventDefault();

        // Gather the data from the form
        const formData = new FormData(form);
        const data = {};

        // Assuming every input has a unique ID that serves as a key
        formData.forEach((value, key) => {
            // Convert checkbox checked state to boolean in JSON
            const isChecked = document.getElementById(key).checked;
            data[key] = isChecked;
        });

        // Convert the JavaScript object to JSON
        const jsonData = JSON.stringify(data);

        // Send the JSON data to the server
        fetch('/api/hacktues/updatedata', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: jsonData,
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
        })
        .then(data => {
            console.log('Success:', data);
        })
        .catch((error) => {
            console.error('Error:', error);
        });
    });
});