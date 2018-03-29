package services.impl;

import models.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.TagRepository;
import services.TagService;

import java.util.List;

@Service("tagService")
public class TagServiceImpl implements TagService{

    @Autowired
    private TagRepository tagRepository;

    @Override
    public Iterable<Tag> findAll() {
        return this.tagRepository.findAll();
    }
}
