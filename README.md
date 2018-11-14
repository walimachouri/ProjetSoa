# ProjetSoa

Endpoint : http://localhost:8080/soapws/

TEST :
Request Post :
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:art="http://www.concretepage.com/cinema-ws">
   <soapenv:Header/>
   <soapenv:Body>
      <art:addCinemaRequest>
         <art:title>colise</art:title>
         <art:adresse>tunis</art:adresse>
      </art:addCinemaRequest>
   </soapenv:Body>
</soapenv:Envelope> 

response :

<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <ns2:addCinemaResponse xmlns:ns2="http://www.concretepage.com/cinema-ws">
            <ns2:serviceStatus>
                <ns2:statusCode>SUCCESS</ns2:statusCode>
                <ns2:message>Content Added Successfully</ns2:message>
            </ns2:serviceStatus>
            <ns2:cinemaInfo>
                <ns2:cinemaId>4</ns2:cinemaId>
                <ns2:title>colise</ns2:title>
                <ns2:adresse>tunis</ns2:adresse>
            </ns2:cinemaInfo>
        </ns2:addCinemaResponse>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
