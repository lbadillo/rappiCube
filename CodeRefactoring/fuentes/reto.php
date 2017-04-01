public function post_confirm() {
	$ERROR0='0';
	$ERROR1='1';
	$ERROR2='2';
	$ERROR3='3';
	$ERROR4='4';

	$id = Input::get('service_id');
	$servicio = Service::find($id);
	$driver=Input::get('driver_id');
	$driverTmp=Driver::find($driver);
	$idError=$ERROR0;
	
	if($servicio != NULL && $driverTmp!=NULL){
		if($servicio->status_id == 6){
			$idError=$ERROR2;
		}
		else if($servicio->driver_id==NULL && $servicio->status_id==1){
			$servicio = Service::update($id, array(
								'driver_id' => $driver,
								'stats_id'=>'2',
								'car_id' => $driverTmp->car_id
								));
			$Driver::update($driver,array("available" => '0'));
			$pushMessage='Tu Servicio ha sido confirmado';
			$servicio=Service:find($id);
			$push =Push::make();
			if(getPushMsg($servicio) == NULL){
				$idError=$ERROR4;
			}
			
		}else {
			$idError=$ERROR1;
		}
	}else {
		$idError=$ERROR3;
	}
	return Response::json(array('error' => $idError));
}

public function getPushMsg($servicio){
	$result= NULL;
	if($servicio->user->type =='1'){
		$result = push->ios($servicio->user-uuid,$pushMessage,1,'honk.wav', 'Open', array('service_id' => $servicio->id));
	} else {
		$result = push->android2($servicio->user-uuid,$pushMessage,1,'default', 'Open', array('service_id' => $servicio->id));
	}
	return $result;
	
}