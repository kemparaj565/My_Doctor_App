import { Component, OnInit } from '@angular/core';
import {NgModule} from '@angular/core';
import {MatTabsModule} from '@angular/material/tabs';
import {RouterModule} from '@angular/router';
import {MatButtonToggleModule} from '@angular/material/button-toggle';
import {ReactiveFormsModule} from '@angular/forms';
import {MatButtonModule} from '@angular/material/button';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatIconModule} from '@angular/material/icon';
import {MatInputModule} from '@angular/material/input';
import {ThemePalette} from '@angular/material/core';


@Component({
  selector: 'my-doctor-header',
  templateUrl: './my-doctor-header.component.html',
  styleUrls: ['./my-doctor-header.component.css']
})
export class MyDoctorHeaderComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  fitInkBarToContent = true;
  links = ['Diseases', 'Symptoms', 'Medicine'];
  activeLink = this.links[0];
  background: ThemePalette = 'primary';
  lotsOfTabs = new Array(30).fill(0).map((_, index) => `Tab ${index}`);

}
