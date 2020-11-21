<?php
require 'vendor/autoload.php';

use Zilic\Mjerenje;
// https://flightphp.com/learn
// preporuka https://medium.com/@h.benkachoud/symfony-rest-api-without-fosrestbundle-and-using-jwt-authentication-part-1-944aa4faf946
Flight::route('GET /v2/mjerenja',function(){

    $mjerenje = new Mjerenje();

    Flight::json($mjerenje->getMjerenja());

});

Flight::map('notFound',function(){
    print_r($_SERVER);
   
});



Flight::start();