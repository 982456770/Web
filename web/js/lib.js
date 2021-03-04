function strToArr(str, symbol) {
    var arr = str.split(symbol);

    if (arr[arr.length - 1] == "") {
        arr.pop();
    } 

    return arr;
}

function People() {
    this.item = [];

    function Element(name, id) {
        this.name = name;
        this.id = id;
    }

    People.prototype.push = (name, id)=>{
        var element = new Element(name, id);

        this.item.push(element);
    }

    // People.prototype.clear = ()=>{
    //     this.item = [];
    // }
}