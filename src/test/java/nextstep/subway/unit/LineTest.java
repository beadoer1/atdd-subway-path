package nextstep.subway.unit;

import nextstep.subway.domain.Line;
import nextstep.subway.domain.Section;
import nextstep.subway.domain.Station;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    @DisplayName("구간 목록 마지막에 새로운 구간을 추가할 경우")
    @Test
    void addSection() {
        Line line = new Line();

        int num = 2;
        for (int i = 0; i < num; i++) {
            line.addSection(new Section());
        }
        assertThat(line.getSections().size()).isEqualTo(num);
    }

    @DisplayName("노선에 속해있는 역 목록 조회")
    @Test
    void getStations() {
        // given
        Line line = new Line();

        final Station 상행역 = new Station("상행역");
        final Station 하행역 = new Station("하행역");
        final Section section = new Section(line, 상행역, 하행역, 1);

        final Section newSection = new Section(line, 하행역, new Station("새로운역"), 1);

        line.addSection(section);
        line.addSection(newSection);

        // when
        List<Station> stations = line.getAllStations();

        // then
        assertThat(stations.size()).isEqualTo(3);
    }

    @DisplayName("구간이 목록에서 마지막 역 삭제")
    @Test
    void removeSection() {
    }
}
