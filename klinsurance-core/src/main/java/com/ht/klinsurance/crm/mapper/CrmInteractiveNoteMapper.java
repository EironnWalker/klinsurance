package com.ht.klinsurance.crm.mapper;

import com.ht.klinsurance.crm.model.CrmInteractiveNote;

import java.util.List;

public interface CrmInteractiveNoteMapper {

    int deleteByPrimaryKey(String interactiveNoteId);

    int deleteAllByusrId(String userId);

    int insertCrmInteractiveNote(CrmInteractiveNote record);

    int insertCrmInteractiveNoteList(List<CrmInteractiveNote> list);

    CrmInteractiveNote selectByPrimaryKey(String interactiveNoteId);

    int updateByPrimaryKeySelective(CrmInteractiveNote record);
}