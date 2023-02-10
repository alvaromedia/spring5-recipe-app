package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

    @Mock
    RecipeRepository recipeRepository;

    RecipeServiceImpl recipeServiceImpl;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        recipeServiceImpl = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipes() {
        Set<Recipe> recipesData = new HashSet<>();
        recipesData.add(new Recipe());

        when(recipeRepository.findAll()).thenReturn(recipesData);
        assertEquals(1, recipeServiceImpl.getRecipes().size());
        verify(recipeRepository, times(1)).findAll();
    }
}