import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'getValues'
})
export class GetValuesPipe implements PipeTransform {

  transform(map: Map<any, any>): any[] {
    let ret = [];
    ret= Object.values(map);
    console.log(ret);
    
    return ret;

  }
}
