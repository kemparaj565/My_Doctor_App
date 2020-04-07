import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MyDoctorHeaderComponent } from './my-doctor-header/my-doctor-header.component';
import { MyDoctorFooterComponent } from './my-doctor-footer/my-doctor-footer.component';
import { MyDoctorSidenavbarComponent } from './my-doctor-sidenavbar/my-doctor-sidenavbar.component';
import { MyDoctorBodyComponent } from './my-doctor-body/my-doctor-body.component';
import { MatTabsModule } from '@angular/material/tabs';
import { RouterModule } from '@angular/router';
import { MatButtonToggleModule } from '@angular/material/button-toggle';
import { MatStepperModule } from '@angular/material/stepper';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';

@NgModule({
  declarations: [
    AppComponent,
    MyDoctorHeaderComponent,
    MyDoctorFooterComponent,
    MyDoctorSidenavbarComponent,
    MyDoctorBodyComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    MatTabsModule,
    RouterModule,
    MatButtonToggleModule,
    MatStepperModule,
    MatButtonModule,
    MatCheckboxModule,
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
