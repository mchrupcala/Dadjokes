package com.lambdaschool.dadjokes.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lambdaschool.dadjokes.logging.Loggable;

import javax.persistence.*;

@Loggable
@Entity
@Table(name = "jokes")
public class Joke extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long jokeid;

    @Column(nullable = false)
    private String jokequestion;

    @Column(nullable = false)
    private String jokeanswer;

    @Column(nullable = false)
    private boolean isprivate;

    @ManyToOne
    @JoinColumn(name = "userid"
//            nullable = false
    )
    @JsonIgnoreProperties("jokes")
    private User user;

    public Joke()
    {
    }

    public Joke(String jokequestion,
                    String jokeanswer, boolean isprivate, User user)
    {
        this.jokequestion = jokequestion;
        this.jokeanswer = jokeanswer;
        this.isprivate = isprivate;
        this.user = user;
    }

    public Joke(String jokequestion,
                String jokeanswer, boolean isprivate) {
        this.jokequestion = jokequestion;
        this.jokeanswer = jokeanswer;
        this.isprivate = isprivate;
    }

    public long getJokeid() {
        return jokeid;
    }

    public void setJokeid(long jokeid) {
        this.jokeid = jokeid;
    }

    public String getJokequestion() {
        return jokequestion;
    }

    public void setJokequestion(String jokequestion) {
        this.jokequestion = jokequestion;
    }

    public String getJokeanswer() {
        return jokeanswer;
    }

    public void setJokeanswer(String jokeanswer) {
        this.jokeanswer = jokeanswer;
    }

    public boolean isIsprivate() {
        return isprivate;
    }

    public void setIsprivate(boolean isprivate) {
        this.isprivate = isprivate;
    }
}
