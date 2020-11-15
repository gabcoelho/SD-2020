namespace java chavevalor
namespace py chavevalor

struct Example {
    1:i32 number,
    2:i64 bigNumber,
    3:double decimals,
    4:string name="thrifty"
}

exception KeyNotFound {
 
}


service ChaveValor
{
    string getKV(1:i32 key) throws (1:KeyNotFound knf),
    bool setKV(1:i32 key, 2:string value),
    void delKV(1:i32 key)
}  