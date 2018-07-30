## Cose da fare:

* Verifica dell'importo della trx pagato dal final client
* Mettere un DB in più in cui conservare le readAPIkey
* Restituire la readAPIkey di Thingspeak al finalClient
* **Risolvere il problema della commissione!** Mettere la class _WalletWrapper_ statica?? **PROVARE**
* Prova finale con i 3 wallet attivi
* Rifinire l'interfaccia grafica per mettere gli importi calcolati automaticamente dalla SIoT
* _REFACTORING:_
    * mettere la FinalClientRMIRootInterface in un progetto a parte e importarlo in **FinalClient** e **SIoT_IoT_Platform** come dipendenza, così non replico il codice
    * boh
* _GRAFICI:_
    * fare 100/200 trx in loop e vedere quanto tempo ci sta la rete a verificarle
    * BOH
* Vedere se si può avviare lo stesso wallet replicato due volte contemporaneamente
* 
