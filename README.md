# FDC Store
È un sito di e-commerce per la vendita di prodotti online.
##Casi d'uso

####Caso D'Uso UC1: Consulta listino
**Attore primario:** Un Utente non registrato.  
+ Un utente può navigare i prodotti e visualizzarne i dettagli.  
A partire da un prodotto può vedere gli utenti che l’hanno acquistato.

_ _ _ _ _
####Caso D'Uso UC2: Effettua ordine  
**Attore primario:** Un Cliente.  
**_Scenario principale di successo:_**  
**1.** Il Cliente vuole comprare dei prodotti effettuando un ordine online  
**2.** Il Cliente inserisce il suo indirizzo di posta elettronica e la sua password.  
&nbsp;&nbsp;&nbsp;&nbsp;Il Sistema verifica la correttezza dei dati immessi, e autentica il Cliente.   
**3.** Il Cliente sceglie l'attività “**_Creazione ordine_**”. Il Sistema mostra il listino prodotti.  
**4.** Il Cliente consulta il listino dei prodotti e aggiunge il codice e la quantità del prodotto scelto all'ordine.  
**5.** Il Sistema imposta il prezzo unitario del prodotto scelto al prezzo corrente di listino.  
_Il Cliente ripete i passi 4-5 fino a che non indica che ha terminato._  
**6.** Il Cliente conferma l'ordine.  
**7.** Il Sistema registra l'ordine.  
&nbsp;&nbsp;&nbsp;&nbsp;Da questo momento in poi l'ordine è completato e può essere visualizzato tra gli ordini effettuati del Cliente.

_ _ _ _ _
####Caso D'Uso UC3: Consulta i propri ordini  
**Attore primario:** Un Cliente.  
**_Scenario principale di successo:_**  
**1.** Il Cliente vuole consultare gli ordini da lui effettuati.  
**2.** Il Cliente inserisce il suo indirizzo di posta elettronica e la sua password.  
&nbsp;&nbsp;&nbsp;&nbsp;Il Sistema verifica la correttezza dei dati immessi, e autentica il Cliente.  
**3.** Il Cliente sceglie l'attività “**_Consulta ordini_**”.  
&nbsp;&nbsp;&nbsp;&nbsp;Il Sistema mostra l'elenco degli ordini effettuati dal Cliente.  
**4.** Il Cliente chiede sceglie un ordine e ne richiede il dettaglio.  
**5.** Il Sistema mostra il dettaglio dell'ordine.  
_Il Cliente ripete i passi 4-5 finché necessario._  

_ _ _ _ _
####Caso D'Uso UC4: Inserimento prodotti nel listino  
**Attore Primario:** Un Amministratore.  
**_Scenario principale di successo:_**  
**1.** L'Amministratore vuole inserire un nuovo prodotto nel listino.  
**2.** L'Amministratore inserisce il suo indirizzo di posta elettronica e la sua password.  
&nbsp;&nbsp;&nbsp;&nbsp;Il Sistema verifica la correttezza dei dati immessi, e autentica l'Amministratore.  
**3.** L'Amministratore sceglie l'attività “**_Inserisci nuovo Prodotto_**".  
**4.** L'Amministratore specifica i dettagli del nuovo prodotto da inserire nel listino.   
_L'Amministratore ripete il passo 4 finché necessario._  
**5.** Il Sistema mostra i prodotti inseriti.  
**6.** L'Amministratore conferma l'inserimento dei prodotti.  
&nbsp;&nbsp;&nbsp;&nbsp;Il Sistema registra le informazioni sui prodotti e li inserisce nel listino.  
&nbsp;&nbsp;&nbsp;&nbsp;Da questo momento in poi potranno essere consultati da Clienti e da utenti non registrati.

_ _ _ _ _
####Caso D'Uso UC5: Recupera indirizzo cliente  
**Attore primario:** Un Amministratore.  
**_Scenario principale di successo:_**  
**1.** L'Amministratore vuole recuperare i dati di un cliente a partire da un ordine.  
**2.** L'Amministratore inserisce il suo indirizzo di posta elettronica e la sua password.  
&nbsp;&nbsp;&nbsp;&nbsp;Il Sistema verifica la correttezza dei dati immessi, e autentica l'Amministratore.  
**3.** L'Amministratore fornisce l'identificatore di un ordine.  
**4.** Il Sistema mostra i dati del Cliente che ha effettuato l'ordine.  

_ _ _ _ _
####Caso D'Uso UC6: Evasione ordine  
**Attore primario:** Un Amministratore.  
**_Scenario principale di successo:_**  
**1.** L'Amministratore vuole evadere un ordine.  
**2.** L'Amministratore inserisce il suo indirizzo di posta elettronica e la sua password.  
&nbsp;&nbsp;&nbsp;&nbsp;Il Sistema verifica la correttezza dei dati immessi, e autentica l'Amministratore.  
**3.** L'Amministratore sceglie l'attività “**_Evasione Ordini_**”.  
**4.** Il Sistema mostra gli ordini chiusi ma non ancora evasi.  
**5.** L'Amministratore sceglie un ordine da evadere.  
**6.** Il Sistema evade l'ordine e aggiorna la quantità di prodotti in magazzino.

_ _ _ _ _
_ _ _ _ _
