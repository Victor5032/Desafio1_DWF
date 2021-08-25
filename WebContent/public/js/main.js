const observaciones_block = document.getElementById("observaciones-block");

const estado_rechazar = document.getElementById("estado-rechazar");
const estado_aprobar = document.getElementById("estado-aprobar");

estado_rechazar.addEventListener("change", (e) => {
    e.preventDefault();

    if (estado_rechazar.checked) {
        observaciones_block.classList.remove("d-none");
        document.getElementById("observaciones").setAttribute("required", "true");

        estado_aprobar.checked = false;
    }
});

estado_aprobar.addEventListener("change", (e) => {
    e.preventDefault();

    if (estado_aprobar.checked) {
        observaciones_block.classList.add("d-none");
        document.getElementById("observaciones").removeAttribute("required");

        estado_rechazar.checked = false;
    }
});

