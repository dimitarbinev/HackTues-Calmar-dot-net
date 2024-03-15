document.addEventListener('DOMContentLoaded', function() {
    const form = document.querySelector('.games-list');
    
    // Fetch and update checkboxes based on server data
    fetch('/api/hacktues/gettags')
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json(); // Parse the response as JSON
    })
    .then(data => {
        // Iterate over the returned data and update checkboxes
        for (const [name, isChecked] of Object.entries(data)) {
            const checkbox = document.querySelector(`input[name="${name}"]`);
            if (checkbox) {
                checkbox.checked = isChecked;
                // Manually trigger a change event to update label styling
                triggerChangeEvent(checkbox);
            }
        }
    })
    .catch(error => {
        console.error('There was a problem with your fetch operation:', error);
    });

    // Handle form submission
    form.addEventListener('submit', function(event) {
        event.preventDefault(); // Prevent the default form submission

        const data = {};
        // Collect the current state of checkboxes
        form.querySelectorAll('input[type="checkbox"]').forEach(checkbox => {
            data[checkbox.name] = checkbox.checked;
        });

        const jsonData = JSON.stringify(data); // Convert to JSON

        // Send the updated data to the server
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
            return response.json(); // Assuming the server sends back a response
        })
        .then(successData => {
            console.log('Success:', successData);
            // Optionally, handle the server's response data
        })
        .catch(error => {
            console.error('Error:', error);
        });
    });
});

// Function to manually trigger a change event for a given element
function triggerChangeEvent(element) {
    const event = new Event('change', {
        'bubbles': true,
        'cancelable': true
    });
    element.dispatchEvent(event);
}