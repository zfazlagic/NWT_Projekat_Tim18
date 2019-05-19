import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AccountComponent } from './account/account.component';
import { AdminpanelComponent } from './adminpanel/adminpanel.component';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookingComponent } from './booking/booking.component';
import { CardetailsComponent } from './cars/cardetails/cardetails.component';
import { CarsComponent } from './cars/cars.component';
import { HeaderComponent } from './header/header.component';
import { HelpComponent } from './help/help.component';
import { LoginComponent } from './login/login.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    CarsComponent,
    CardetailsComponent,
    AdminpanelComponent,
    HelpComponent,
    AccountComponent,
    BookingComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
