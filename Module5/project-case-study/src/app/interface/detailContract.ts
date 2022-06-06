import {Contract} from "./contract";
import {AttachService} from "./attachService";

export interface DetailContract {
  id: number;
  contract: Contract;
  attachService: AttachService;
  quantity:number
}
