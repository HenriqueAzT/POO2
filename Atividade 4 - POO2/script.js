const form = document.querySelector('form')
const palpitesOutput = document.querySelector('#palpites')
const btnReiniciar = document.querySelector('#reiniciar')
const btnIniciar = document.querySelector('#iniciar')
const btnVerificar = document.querySelector('#verificar')
const resultado = document.querySelector('#resultado')
const numeroTentativas = document.querySelector('#numeroTentativas')

const golsBrasil = Math.floor(Math.random() * 11);
const golsAlemanha = Math.floor(Math.random() * 11);
console.log(golsBrasil, golsAlemanha);

let tentativas = 10

const addPalpites = (inputBrasil, inputAlemanha) => {
    palpitesOutput.textContent += `|| ${inputBrasil} x ${inputAlemanha} `
}

btnIniciar.addEventListener('click', () => {
    btnIniciar.style.display = 'none';
    btnVerificar.removeAttribute('disabled');
    btnReiniciar.style.display = '';
});

btnReiniciar.addEventListener('click', () => {
    location.reload();
});

btnVerificar.addEventListener('click', (event) => {
    event.preventDefault()
    const inputBrasil = document.querySelector('#inputBrasil').value
    const inputAlemanha = document.querySelector('#inputAlemanha').value
    
    --tentativas
    resultado.textContent = ''
    dicas.textContent = ''

    if(Number(inputBrasil) === Number(golsBrasil) 
        && Number(inputAlemanha) === Number(golsAlemanha)){
        resultado.textContent = 'Parabéns você acertou!'
    }else if(tentativas === 0){
        resultado.textContent = 
            `Você não acertou o placar em 10 tentativas. O jogo terminou em Brasil ${golsBrasil} x ${golsAlemanha} Alemanha.`
        return
    }
        if (golsBrasil > inputBrasil) {
            dicas.textContent += 'O Brasil fez mais gols!'
        }else if (golsBrasil < inputBrasil) {
            dicas.textContent += 'O Brasil fez menos gols!'
        }
    
        if (golsAlemanha > inputAlemanha) {
            dicas.textContent += 'A Alemanha fez mais gols!'
        }else if (golsAlemanha < inputAlemanha) {
            dicas.textContent += 'A Brasil fez menos gols!'
        }
    
    if (inputBrasil && inputAlemanha ) {
        addPalpites(inputBrasil, inputAlemanha);
    }else{
        window.alert('Insira valores válidos')
    }

    numeroTentativas.textContent = `Número de tentativas restantes: ${tentativas}`
})