import { Component } from '@angular/core';
import { MyDoctorHeaderComponent } from './my-doctor-header/my-doctor-header.component';
import { MyDoctorSidenavbarComponent } from './my-doctor-sidenavbar/my-doctor-sidenavbar.component';
import { MyDoctorFooterComponent } from './my-doctor-footer/my-doctor-footer.component';
import { MyDoctorBodyComponent } from './my-doctor-body/my-doctor-body.component';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'my-doctor-ui';
}
