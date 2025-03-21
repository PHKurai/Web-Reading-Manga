$(document).ready(function () {
    $('#chooseImageBtn').click(function () {
        $('#imageUpload').click();
    });

    $('#imageUpload').change(function () {
        const file = this.files[0];
        if (file) {
            if (!file.type.match('image.*')) {
                alert('Please select a valid image file.');
                this.value = '';
                $('#fileInfo').text('No file selected');
                return;
            }

            const fileSize = (file.size / 1024).toFixed(2) + ' KB';
            $('#fileInfo').text(file.name + ' (' + fileSize + ')');

            const reader = new FileReader();
            reader.onload = function (e) {
                const base64String = e.target.result;
                $('#txtImage').val(base64String);
                $('#imagePreview').html('<img src="' + base64String + '" alt="Preview" onerror="this.src=\'assets/images/placeholder.png\';">');
            };
            reader.readAsDataURL(file);
        } else {
            $('#fileInfo').text('No file selected');
        }
    });
    
   
});

