import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'my-doctor-body',
  templateUrl: './my-doctor-body.component.html',
  styleUrls: ['./my-doctor-body.component.css']
})
export class MyDoctorBodyComponent implements OnInit {


  isLinear = true;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  thirdFormGroup: FormGroup;

  constructor(private _formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.firstFormGroup = this._formBuilder.group({
      firstCtrl: ['', Validators.required]
    });
    this.secondFormGroup = this._formBuilder.group({
      secondCtrl: ['', Validators.required]
    });
    this.thirdFormGroup = this._formBuilder.group({
      thirdCtrl: ['']
    });
  }

  emailFormControl = new FormControl('', [
    Validators.required,
    Validators.email,
  ]); 

  phoneFormControl = new FormControl('', [
    Validators.required,
    Validators.email,
  ]); 

  gender: string[] = ['Male', 'Female', 'Trans-Gender', 'Won\'t Reveal'];
}
