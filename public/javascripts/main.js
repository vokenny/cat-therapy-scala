(function() {
    'use strict';

    $("#meow").click(() => {
        let url = 'https://api.thecatapi.com/v1/images/search';

        fetch(url)
            .then(res => res.json())
            .then(catRes => {
                $('.img-container').html(
                    `<img src="${catRes[0].url}" class="card-img" alt="Random cat image">`
                )
            });
    });
}());