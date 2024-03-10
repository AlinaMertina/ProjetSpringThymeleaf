//fonction mipetraka amn le buton  plus kely ambonin'le table 
function addRow(event) {
    event.preventDefault();
    let nouveauDiv = document.createElement("tbody");
    let produit = document.getElementsByClassName("rowindex0")[0];
    nouveauDiv.innerHTML = produit.outerHTML;
    let supprimer = nouveauDiv.querySelector("#supprimer");
    supprimer.addEventListener('click', function() {
        nouveauDiv.parentElement.removeChild(nouveauDiv);
    });
    document.getElementsByClassName("tableAddRow")[0].appendChild(nouveauDiv); // sotratana amn le table misy an'le action ajout de ligne
}

function egale(event){
    event.preventDefault();
    const formData = new FormData(document.getElementById("egale")); 
    const formDataObject = {};
    let pourcentage =0.0;
    for (const [key, value] of formData.entries()) {
        if (key === 'pourcentage[]') {
            pourcentage=pourcentage+parseFloat(value);
        }
    }
    if(pourcentage<100){
        alerteEgale("la sommme des pourcentage non egale a 100");
    }
    console.log(pourcentage);

}
function alerteEgale(text) {     
    console.log("non equilibree");  
    let value = document.getElementById("textalert");
    value.innerHTML = "<h4>" + text + "</h4>"; // Utilisation de innerHTML pour modifier le contenu de l'élément
    document.getElementById('alertValue').style.display = 'block';
}

function closepopup() {
  document.getElementById('alertValue').style.display='none';
}

function sendeinsert(event,url){
    event.preventDefault(); 
    const formData = new FormData(document.getElementById("sendeinsert")); 
    const headers = new Headers();
    const formDataObject = {};
    for (const [key, value] of formData.entries()) {
        formDataObject[key] = isNaN(value) ? value : parseInt(value, 10);
    }
    console.log(formDataObject);
    headers.append('Content-Type', 'application/json');
    fetch(url, {
        method: "POST",
        headers: headers,
        body: JSON.stringify(formDataObject)
    })
    .then(response => response.json()) 
    .then(data => {
        if(data.error!=null){
            alerteEgale(data.error);
        }
        console.log(data);
    })
    .catch(error => {
        console.error(error);
        alerteEgale(error);
    });
}
