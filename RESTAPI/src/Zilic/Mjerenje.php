<?php
namespace Zilic;

use stdClass;
use Faker\Factory;

class Mjerenje
{
    public function getMjerenja()
    {
        $faker = Factory::create('hr_HR');
        $mjerenja=[];
       
        for($i=1;$i<=25;$i++){
            $m = new stdClass();
            $m->sifra=$i;
            $m->datum=$faker->iso8601($max = 'now') ;
            $m->iznos=$faker->randomFloat($nbMaxDecimals = 2, $min = 0, $max = NULL);
            $mjerenja[]=$m;
        }
        return $mjerenja;
    }
}