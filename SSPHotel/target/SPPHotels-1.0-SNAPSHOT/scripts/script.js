// Función para determinar si el elemento está en la vista
function isElementInViewport(el) {
  const rect = el.getBoundingClientRect();
  return (
    rect.top <= window.innerHeight / 2 &&
    rect.bottom >= window.innerHeight / 2
  );
}

// Función para manejar el evento de desplazamiento
function handleScroll() {
  const headerItalia = document.getElementById('header-italia');

  if (isElementInViewport(headerItalia)) {
    headerItalia.classList.add('visible');
  }
}

// Agregar el evento de desplazamiento
window.addEventListener('scroll', handleScroll);

// Llamar a la función handleScroll cuando se carga la página (en caso de que el encabezado sea visible desde el principio)
window.addEventListener('load', handleScroll);
