import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-form-input',
  templateUrl: './form-input.component.html',
  styleUrls: ['./form-input.component.css']
})
export class FormInputComponent {
  @Input() campo: string = "";
  @Input() titulo: string = "";
  @Input() tipo: string = "text";
}
