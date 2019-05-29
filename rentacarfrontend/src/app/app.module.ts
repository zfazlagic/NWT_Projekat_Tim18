import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import { CarouselModule } from 'ngx-bootstrap/carousel';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CarsComponent } from './cars/cars.component';
import { HeaderComponent } from './header/header.component';
import { HelpComponent } from './help/help.component';
import { HomeComponent } from './home/home.component';
import { ModalModule } from 'ngx-bootstrap/modal';
import { BookingComponent } from './booking/booking.component';
import { AccordionModule } from 'ngx-bootstrap/accordion';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ContactComponent } from './contact/contact.component';
import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';
import { TabsModule } from 'ngx-bootstrap/tabs';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import {HttpClientModule} from "@angular/common/http";


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    CarsComponent,
    HelpComponent,
    BookingComponent,
    ContactComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CarouselModule.forRoot(),
    AngularFontAwesomeModule,
    ModalModule.forRoot(),
    AccordionModule.forRoot(),
    BrowserAnimationsModule,
    BsDatepickerModule.forRoot(),
    TabsModule.forRoot(),
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }




