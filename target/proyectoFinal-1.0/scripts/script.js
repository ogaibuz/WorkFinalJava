document.getElementById("btnSelectHtml").addEventListener("click", function(){
    btnPush('HTML')
});

document.getElementById("btnSelectPython").addEventListener("click", function(){
    btnPush('Python')
});

document.getElementById("btnSelectIA").addEventListener("click", function(){
    btnPush('Inteligencia Artificial')
});

function btnPush(boton) {
    alert("Proximamente abiertas las inscripciones para el Curso " + boton); 
}