<%@ page contentType="text/html; charset=UTF-8" %>

<jsp:include page="../layouts/header.jsp"  ></jsp:include>

<h2>Instalacija</h2>

<p>
Za korištenje url shortenera potrebno je imati imati slijedeće:
<ul>
 	<li>Eclipse</li>
 	<li>Postman</li>
 	<li>Neki internet browser</li>
</ul>
</p>

<p>
Prvo je potrebno importati kod u Eclipse.
<ul>
 	<li>Skinuti zip datoteku s kodom</li>
 	<li>Raspakirati zip datoteku</li>
 	<li>Importati u eclipse raspakirani kod: File -> Import -> Maven -> Existing maven project</li>
</ul>
</p>


<h2>Pokretanje</h2>

<p>
Pokreće se Run as -> Maven build, a za goals se upiše: "tomcat7:run"
</p>

<h2>Korištenje</h2>

<p>
Koristi se na dva načina
<ul>
 	<li>Konfiguracijski dio - koristi se Postman</li>
 	<li>Klijentski dio - koristi se neki internet browser</li>
</ul>

<h3>Konfiguracijski dio</h3>
Slijedeći dio izvodi se u Postmanu
<h4>Otvaranje account-a</h4>
Razlikujemo dvije vrste registracije, uspješnu i neuspješnu. Neuspješna registracija dogodi se kada  je account koji želimo registrirati već registriran. 

</br>
U oba slučaja potrebno je napraviti slijedeće korake:
<ul>
 	<li>Odabrati POST metodu</li>
 	<li>Za url upisati "http://localhost:8080/account"</li>
 	<li>Autentifikaciju ne postavljamo</li>
 	<li>U body upisati slijedeće : "{ "accountId" : "myAccountId"}"</li>
</ul>

Ako je registracija bila uspješna, očekuje se slijedeći odgovor:
<p>{"success":true,"description":"Account myAccountId successfully registered","password":"7Hj4vRK5"}</p>
a ako je bila neuspjesna:
<p> {"success":false,"description":"Account myAccountId not successfully registered because already exists"} </p>


<h4>Registracija URL-ova</h4>
Registracija URL-ova također može biti uspješna i neuspješna. Ako je registracija uspješna, vraća se json sa novim kratkim url-om, a ako je neuspješna, također se vraća json sa već postojećim kratkim url-om.
Registracija url-a je neuspješna ako je taj url već registriran. 
</br>
Postupak:
<ul>
 	<li>Odabrati POST metodu</li>
 	<li>Za url upisati "http://localhost:8080/register"</li>
 	<li>Autentifikaciju postavljamo: Odabiremo Basic autentifikaciju, a za username i password upisujemo registrirani account i odgovarajuću lozinku</li>
 	<li>U body upisati slijedeće : "{
			"url": "http://webmail.fer.hr",
			"redirectType" : "301"
			}"
	</li>
</ul>

Ako smo dobro podesili parametre autentifikacije odgovor bi trebao biti: {
"url": "http://webmail.fer.hr",
"redirectType" : "301"
}


 

<h4>Dohvat statistike</h4>
Pomoću statistike prikazujemo koje je sve url-ove neki autentificirani korisnik registrirao, te koliko su puta posjećeni od strane neuatentificiranih korisnika. 

</br>
Postupak:
<ul>
 	<li>Odabrati GET metodu</li>
 	<li>Za url upisati "http://localhost:8080/statistic/{@idRegistriranogKorisnika}"</li>
 	<li>Autentifikaciju postavljamo: Odabiremo Basic autentifikaciju, a za username i password upisujemo registrirani account i odgovarajuću lozinku</li>
</ul>

Ako je taj registriarni korisnik registrirao koji url,u odgovoru bi trebao dobiti mapu sa svim linkovima koje je registrirao i koliko puta im se pristupilo pomoću skraćenog linka od strane neutentificiranih korisnika: "{"www.net.hr":2,"http://webmail.fer.hr":3}"


</p>

<h3>Korisnički dio dio</h3>
Slijedeći dio izvodi se u Chrome-u
<h4>Redirekcija pomoću kratkog url-a</h4>


Postupak:
<ul>
 	<li>Za url upisati "http://localhost:8080/redirect"</li>
 	<li>Postojeći kratki link upisati u textbox</li>
</ul>

Ako je redirekcija neuspješna, pojaviti će se poruka kako taj url ne postoji, a ako je uspješna, biti ćemo preusmjereni na odgovarajući url. 
</br> U slučaju da je URL registriran s kodom 302, pojaviti će se poruka da resurs trenutno nije dostupan, međutim u budućosti bi trebao biti. 
</br> Bilježi se svaki pristup url-u za statistiku posjeta. 

<h3>NOTE:</h3>
<p>
Pri spremanju url-ova nisam provjeravala postoje li zaista i što se tiče spremanja lozinka, ne bi trebalo spremati lozinku, već hash. 
</p>

<jsp:include page="../layouts/footer.jsp"  ></jsp:include>