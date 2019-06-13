import { HttpClient } from '@angular/common/http';
import { EventEmitter, Injectable, Output } from '@angular/core';
import { LocalStorageService } from 'angular-web-storage';
import { map } from 'rxjs/operators';
import { Activity } from '../models/activity';
import { ActivityDetails } from '../models/activityDetails';
import { Reservation } from '../models/reservation';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  reservationInfo: Reservation;

  @Output() reservationSelected: EventEmitter<Reservation> = new EventEmitter();

  constructor(private http: HttpClient, private storage: LocalStorageService) { }

  onReservationSelected(reservation: Reservation) {
    this.reservationSelected.emit(reservation);
    this.reservationInfo = reservation;
  }

  createReservation() {
    
    debugger;
    let activity = this.createNewActivity();

    const headers = {
      'Content-type': 'application/json'
    };
    let body = JSON.stringify(activity);
    this.createReservationDetails(activity);
    return this.http.post('http://localhost:8083/activity/addActivity', body, { headers }
    ).pipe(map((res: Response) => {
      console.log("Response from POST req for new Activity: " + res);
    }));
  }

  createReservationDetails(activity: Activity) {
    let activityDetails = new ActivityDetails();
    activityDetails.location = null;
    activityDetails.beginDate = this.reservationInfo.startDate;
    activityDetails.endDate = this.reservationInfo.endDate;
    activityDetails.activityId = 0;

    const headers = {
      'Content-type': 'application/json'
    };
    let body = JSON.stringify(activityDetails);
    return this.http.post('http://localhost:8083/activityDetails/addDetail', body, { headers }
    ).pipe(map((res: Response) => {
    }));
  }

  createNewActivity() {
    let activity = new Activity();
    // Fix this!
    activity.userId = 8888;
    activity.carId = this.reservationInfo.car.id;
    activity.isRental = this.reservationInfo.isRental ? 1 : 0;
    activity.isReservation = !this.reservationInfo.isRental ? 1 : 0;
    return activity;
  }
}
