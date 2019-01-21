/* VALIDACIÓN JS PARA FORMATO MÓVIL (ES) 

function validate(value){

    var str = value.toString().replace(/\s/g, '');    
    return str.length === 9 && /^[679]{1}[0-9]{8}$/.test(str);
}

validate('639 125 230'); //true
validate('668515187');   //true
validate('133 560 158'); //false
validate('932 510 258'); //true */