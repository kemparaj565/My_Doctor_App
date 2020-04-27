import { Component, ElementRef, ViewChild, Input, Output, EventEmitter, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { COMMA, ENTER} from '@angular/cdk/keycodes';
import { MatAutocompleteSelectedEvent, MatAutocomplete} from '@angular/material/autocomplete';
import { MatChipInputEvent} from '@angular/material/chips';
import { Observable} from 'rxjs';
import { map, startWith} from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';


export interface Tile {
  color: string;
  cols: number;
  rows: number;
  text: string;
}

export interface Disease{
  id: number;
	diseaseName: string;
	symptom: string;
	diseaseDescription: string;
	durationOfDisease: number;
}

export interface ConsultationForm{
  patientName: any;
  patientGender: any;
  patientDOB: any;
  patientBloodGroup: any;
  patientHeight: any;
  patientWeight: any;
  patientEmailAddress: any;
  patientPhoneNumber: any;
} 

export interface Medicine{
  id: number;
  medicineName: string;
  diseaseName: string;
  symptomName: string;
  treatmentDescription: string;
  numberOfTimesPrescribed: number;
  vendorName: string;
  durationToUse: number;
}


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
  
  httpHeader: HttpHeaders;

  constructor(private _formBuilder: FormBuilder,private http: HttpClient) {
    this.filteredFruits = this.fruitCtrl.valueChanges.pipe(
      startWith(null),
      map((fruit: string | null) => fruit ? this._filter(fruit) : this.allDiseases.slice()));
   }

  ngOnInit(): void {
    this.firstFormGroup = this._formBuilder.group({
      //firstCtrl: ['', Validators.required]
      patientName: [''],
      patientGender: [''],
      patientDOB: [''],
      patientBloodGroup: [''],
      patientHeight: [''],
      patientWeight: [''],
      patientEmailAddress: [''],
      patientPhoneNumber: ['']
    });
    this.secondFormGroup = this._formBuilder.group({
      secondCtrl: [''],
      patientDisease: ['']
    });
    this.thirdFormGroup = this._formBuilder.group({
      thirdCtrl: [''],
      underLyingConditions:[''],
      anySurgeries:[''],
      anyMedications:[''],
      otherDetails:['']
    });
  }

  tiles: Tile[] = [
    {text: 'One', cols: 3, rows: 1, color: '#eee'},
    {text: 'Two', cols: 4, rows: 2, color: 'lightgreen'},
    {text: 'Three', cols: 3, rows: 1, color: 'lightpink'},
    {text: 'Four', cols: 2, rows: 1, color: '#DDBDF1'},
  ];

  emailFormControl = new FormControl('', [
    Validators.required,
    Validators.email,
  ]); 

  phoneFormControl = new FormControl('', [
    Validators.required,
    Validators.email,
  ]); 

  gender: string[] = ['Male', 'Female', 'Trans-Gender', 'Won\'t Reveal'];

  startDate = new Date(1975, 0, 1);

  showFiller = false;

  value = 'Clear me';

  visible = true;
  selectable = true;
  removable = true;
  separatorKeysCodes: number[] = [ENTER, COMMA];
  fruitCtrl = new FormControl();
  filteredFruits: Observable<string[]>;
  fruits: string[]= new Array();
  diseases: Disease[] = this.getDiseaseData();
  diseaseList: string[]=new Array();
  allDiseases: string[] = this.diseaseList;
  consultationFormData: any = new FormData();
  patientInformation: ConsultationForm;
  patientArray: string[]= new Array();
  patientDiseaseArray: string[] = new Array();
  medicines: Medicine[]= new Array();

  @ViewChild('diseaseInput') diseaseInput: ElementRef<HTMLInputElement>;
  @ViewChild('auto') matAutocomplete: MatAutocomplete;
 

  add(event: MatChipInputEvent): void {
    const input = event.input;
    const value = event.value;

    // Add our fruit
    if ((value || '').trim()) {
      this.fruits.push(value.trim());
    }

    // Reset the input value
    if (input) {
      input.value = '';
    }

    this.fruitCtrl.setValue(null);
  }

  remove(fruit: string): void {
    const index = this.fruits.indexOf(fruit);

    if (index >= 0) {
      this.fruits.splice(index, 1);
    }
  }

  selected(event: MatAutocompleteSelectedEvent): void {
    this.fruits.push(event.option.viewValue);
    this.diseaseInput.nativeElement.value = '';
    this.fruitCtrl.setValue(null);
  }

  private _filter(value: string): string[] {
    const filterValue = value.toLowerCase();

    return this.allDiseases.filter(fruit => fruit.toLowerCase().indexOf(filterValue) === 0);
  }

  
  public getDiseaseData(){
    this.http.get<Disease[]>('http://localhost:8080/list-diseases').subscribe(data => {
     this.diseases = data;
  }); 
  return this.diseases;
}


public getDiseasesList(): string[]{

  while(this.diseaseList.length!=0){
  this.diseaseList.pop();
}
  for( let  i of Object.keys(this.diseases ))
{
  var element=this.diseases[i];
   this.diseaseList.push(element.diseaseName);
}
return this.diseaseList;
}

public getPatientData(){
   
   var patientData={
    patientName: this.firstFormGroup.controls['patientName'].value,
    patientGender: this.firstFormGroup.controls['patientGender'].value,
    patientDOB: this.firstFormGroup.controls['patientDOB'].value,
    patientBloodGroup: this.firstFormGroup.controls['patientBloodGroup'].value,
    patientHeight: this.firstFormGroup.controls['patientHeight'].value,
    patientWeight: this.firstFormGroup.controls['patientWeight'].value,
    patientEmailAddress: this.firstFormGroup.controls['patientEmailAddress'].value,
    patientPhoneNumber: this.firstFormGroup.controls['patientPhoneNumber'].value
  };
  this.patientInformation=patientData;
  this.getDiseasesList();
  this.patientArray.push(this.patientInformation.patientName);
  this.patientArray.push(this.patientInformation.patientGender);
  this.patientArray.push(this.patientInformation.patientDOB);
  this.patientArray.push(this.patientInformation.patientBloodGroup);
  this.patientArray.push(this.patientInformation.patientHeight);
  this.patientArray.push(this.patientInformation.patientWeight);
  this.patientArray.push(this.patientInformation.patientEmailAddress);
  this.patientArray.push(this.patientInformation.patientPhoneNumber);
}

public getMedicalHistory(){
  var medicalHistory={
        underLyingConditions: this.thirdFormGroup.value.underLyingConditions,
        anySurgeries: this.thirdFormGroup.value.anySurgeries,
        anyMedications: this.thirdFormGroup.value.anyMedications,
        otherDetails: this.thirdFormGroup.value.otherDetails

  };
  if(medicalHistory.anySurgeries=='' || medicalHistory.underLyingConditions==''||medicalHistory.anyMedications==''||medicalHistory.otherDetails==''){
    this.patientArray.push("None");
    this.patientArray.push("None");
    this.patientArray.push("None");
    this.patientArray.push("None");
  }
  else{
    this.patientArray.push(medicalHistory.underLyingConditions);
    this.patientArray.push(medicalHistory.anySurgeries);
    this.patientArray.push(medicalHistory.anyMedications);
    this.patientArray.push(medicalHistory.otherDetails);
  }
  this.getMedicineInformation();
}  

public getMedicineInformation(){
  let url='http://localhost:8080/list-medicine-by-disease?diseaseName='+this.fruits[0];
  this.http.get<Medicine[]>(url).subscribe(data => {
   this.medicines = data;
}); 
let medArr:Medicine[] = new Array();

if(medArr.length==0){
  medArr.push(this.medicines[0]);
}

  for(let i=0,j=1; i<this.medicines.length,j<this.medicines.length-1;i++,j++){

    if(this.medicines[i].medicineName==this.medicines[j].medicineName){
      continue;
    }
    else{
      medArr.push(this.medicines[i]);
    }

}

this.medicines=new Array();
this.medicines=medArr;
console.log(medArr);
console.log(this.medicines.filter((obj, pos, arr) => {
  return arr.map(mapObj => mapObj["value"]).indexOf(obj["value"]) === pos;
}));
return this.medicines;
}


}
