package com.example.managers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.example.entities.Enquiry;
import com.example.repositories.EnquriyRepository;
import com.example.managers.*;

@Service
public class EnquiryImpl implements EnquiryService {

	@Autowired
	private EnquriyRepository e;

	public void Formsubmit(Enquiry enq) {
		e.save(enq);
		// e.addEnquiry(enq.getEnquirer_name(), enq.getEnquirer_mobile(),
		// enq.getEnquirer_email_id(), enq.getEnquirer_query(), enq.getStaff_id());;
	}

	public List<Enquiry> GetAll() {
		return e.findAll();
	}

	public Optional<Enquiry> FindById(int id) {
		return e.findById(id);
	}

	@Override
	public Optional<Enquiry> GetByName(String name) {

		Optional<Enquiry> p = e.findByName(name);
		return p;
	}

	/*public void update(Enquiry enq, int id) {
		e.updatedata(enq.getEnquirer_name(),enq.getEnquirer_mobile(),enq.getEnquirer_email_id(), enq.getEnquirer_query(), enq.getClosure_reason(),enq.isEnquiry_processed_flag(),id);

	}*/
	
//	@Override
//	public void updateEnquiry(int enquiryId, Enquiry enquiry) {
//        Optional<Enquiry> existingEnquiry = e.findById(enquiryId);
//
//        // Update the existing Enquiry object with the new values
//        existingEnquiry.(enquiry.getEnquirer_name());
//        existingEnquiry.setEnquirerMobile(enquiry.getEnquirer_mobile());
//        existingEnquiry.setEnquirerEmailId(enquiry.getEnquirer_email_id());
//        existingEnquiry.setEnquiryDate(enquiry.getEnquiry_date());
//        existingEnquiry.setFollowUpDate(enquiry.getFollow_up_date());
//        existingEnquiry.setClosureReason(enquiry.getClosure_reason());
//        existingEnquiry.setFollowupMsg(enquiry.getFollowup_msg());
//        existingEnquiry.setEnquirerQuery(enquiry.getEnquirer_query());
//        existingEnquiry.setEnquiryProcessedFlag(enquiry.isEnquiryProcessedFlag());
//        existingEnquiry.setStaffId(enquiry.getStaffId());
//
//        // Save the updated Enquiry object
//        enquiryRepository.save(existingEnquiry);
//    }

	@Override
	public List<Enquiry> getEnquiriesByStaffId(int staff_id) {
		return e.findByStaff_id(staff_id);
	}

	@Override
	public void update(Enquiry e, int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEnquiry(int enquiryId, Enquiry enquiry) {
		// TODO Auto-generated method stub
		e.updatedata(enquiry.getEnquirer_name(),enquiry.getEnquirer_mobile(), enquiry.getEnquirer_email_id(), enquiry.getEnquirer_query(),enquiry.getClosure_reason(),enquiry.getFollowup_msg(),enquiry.isEnquiry_processed_flag(),enquiryId);
	}

	@Override
	public void updateprocessflag(int id) {
		e.changeflagbyid(id);
		//e.changeflagbyid(flag,id);
//Optional<Enquiry> enquiryOptional = e.findById(id);
//        
//        if (enquiryOptional.isPresent()) {
//            Enquiry enquiry = enquiryOptional.get();
//            enquiry.setEnquiry_processed_flag(true);
////            System.err.println("hi");
//		
//	}


	}
}
