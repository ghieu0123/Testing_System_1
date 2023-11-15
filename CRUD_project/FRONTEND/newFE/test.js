function RSA(){
    var text = "Hello World";
    var privkey="MIICdQIB..........";
    var pubkey="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCvFZQtGLPQKV0h....";

    var encrypt = new JSEncrypt();
    encrypt.setPublicKey(pubkey);
    var ciphertext = encrypt.encrypt(text);
    console.log("ciphertext  : " + base64ToHex(ciphertext));

    var decrypt = new JSEncrypt();
    decrypt.setPrivateKey(privkey);
    var plaintext = decrypt.decrypt(hexToBase64(cipher));
    console.log("plaintext  : " + plaintext);
}   