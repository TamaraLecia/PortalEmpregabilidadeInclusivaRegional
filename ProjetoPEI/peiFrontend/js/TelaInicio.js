document.querySelectorAll('.menu-header').forEach(header => {
    header.addEventListener('click', () => {
      header.classList.toggle('active');
    });
  });
  