package com.busecnky.player.mvccontroller;

import com.busecnky.player.mvccontroller.model.PlayerIndexModel;
import com.busecnky.player.repository.entity.ETeam;
import com.busecnky.player.service.GroupService;
import com.busecnky.player.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import static com.busecnky.player.constants.EndPoints.*;
@Controller
@RequestMapping(MVCPLAYER)
@RequiredArgsConstructor
public class PlayerMvcController {

    private final PlayerService playerService;
    private final GroupService groupService;

    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        PlayerIndexModel model = new PlayerIndexModel();
        model.setPlayerDtoList(playerService.findAllResponseDtos());
        modelAndView.addObject("model", PlayerIndexModel.builder()
                .playerDtoList(playerService.findAllResponseDtos())
                .group1DtoList(groupService.findAllResponseDtos())
                .group2DtoList(groupService.findAllResponseDtos())
                .btnekle("→")
                .btnsil("←")
                .build()

        );
        return modelAndView;
    }

    @PostMapping("/addone")
    public ModelAndView addone(Long jerseyNo){
        System.out.println(jerseyNo);
        groupService.saveOne(jerseyNo);

        try{
            if(jerseyNo != null && jerseyNo>0){
                playerService.deleteJerseyNo(jerseyNo);
            }
        }catch (Exception exception){
            System.out.println("Hata oluştu..." + exception.toString());
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");

        modelAndView.addObject("model", PlayerIndexModel.builder()
                .playerDtoList(playerService.findAllResponseDtos())
                .group1DtoList(groupService.findAllResponseDtos().stream().filter(x->x.getTeamType()== ETeam.TEAM1).toList())
                .group2DtoList(groupService.findAllResponseDtos().stream().filter(x->x.getTeamType()== ETeam.TEAM2).toList())
                .btnekle("→")
                .btnsil("←")
                .build()

        );
        return modelAndView;
    }
    @PostMapping("/addtwo")
    public ModelAndView addtwo(Long jerseyNo){
        System.out.println(jerseyNo);
        groupService.saveTwo(jerseyNo);

        try{
            if(jerseyNo != null && jerseyNo>0){
                playerService.deleteJerseyNo(jerseyNo);
            }
        }catch (Exception exception){
            System.out.println("Hata oluştu..." + exception.toString());
        }


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");


        modelAndView.addObject("model", PlayerIndexModel.builder()
                .playerDtoList(playerService.findAllResponseDtos())
                .group1DtoList(groupService.findAllResponseDtos().stream().filter(x->x.getTeamType()== ETeam.TEAM1).toList())
                .group2DtoList(groupService.findAllResponseDtos().stream().filter(x->x.getTeamType()== ETeam.TEAM2).toList())
                .btnekle("→")
                .btnsil("←")
                .build()

        );
        return modelAndView;
    }

    @PostMapping("/delone")
    public ModelAndView delOne(Long jerseyNo){
        System.out.println(jerseyNo);
        playerService.saveMain(jerseyNo);

        try{
            if(jerseyNo != null && jerseyNo>0){
                groupService.deleteJerseyNo(jerseyNo);
            }
        }catch (Exception exception){
            System.out.println("Hata oluştu..." + exception.toString());
        }


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");

        modelAndView.addObject("model", PlayerIndexModel.builder()
                .playerDtoList(playerService.findAllResponseDtos())
                .group1DtoList(groupService.findAllResponseDtos().stream().filter(x->x.getTeamType()== ETeam.TEAM1).toList())
                .group2DtoList(groupService.findAllResponseDtos().stream().filter(x->x.getTeamType()== ETeam.TEAM2).toList())
                .btnekle("→")
                .btnsil("←")
                .build()

        );
        return modelAndView;
    }

    @PostMapping("/deltwo")
    public ModelAndView delTwo(Long jerseyNo){
        System.out.println(jerseyNo);
        playerService.saveMain(jerseyNo);

        try{
            if(jerseyNo != null && jerseyNo>0){
                groupService.deleteJerseyNo(jerseyNo);
            }
        }catch (Exception exception){
            System.out.println("Hata oluştu..." + exception.toString());
        }


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");

        modelAndView.addObject("model", PlayerIndexModel.builder()
                .playerDtoList(playerService.findAllResponseDtos())
                .group1DtoList(groupService.findAllResponseDtos().stream().filter(x->x.getTeamType()== ETeam.TEAM1).toList())
                .group2DtoList(groupService.findAllResponseDtos().stream().filter(x->x.getTeamType()== ETeam.TEAM2).toList())
                .btnekle("→")
                .btnsil("←")
                .build()

        );
        return modelAndView;
    }

}
